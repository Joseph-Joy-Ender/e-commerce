package com.semicolon.africa.commerce.services.sellerService;


import com.semicolon.africa.commerce.data.models.Seller;
import com.semicolon.africa.commerce.data.repositories.SellerRepository;
import com.semicolon.africa.commerce.dtos.LoginRequest;
import com.semicolon.africa.commerce.dtos.RegisterSellerRequest;
import com.semicolon.africa.commerce.exceptions.InvalidDetailsException;
import com.semicolon.africa.commerce.exceptions.SellerException;
import com.semicolon.africa.commerce.utils.ApiResponse;
import com.semicolon.africa.commerce.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public ApiResponse register(RegisterSellerRequest registerSellerRequest) {
        if (checkIfUserExist(registerSellerRequest.getEmailAddress())) throw new SellerException(GenerateApiResponse.SELLER_ALREADY_EXIST);
        Seller seller = modelMapper.map(registerSellerRequest, Seller.class);
        sellerRepository.save(seller);
        return GenerateApiResponse.created(GenerateApiResponse.SELLER_SUCCESSFULLY_REGISTERED);
    }

    @Override
    public ApiResponse login(LoginRequest loginRequest) {
        Seller foundSeller = sellerRepository.findByEmailAddress(loginRequest.getEmailAddress());
        if (!checkIfUserExist(loginRequest.getEmailAddress())) throw new InvalidDetailsException(GenerateApiResponse.LOGIN_CREDENTIALS_IS_INVALID);
        if (!foundSeller.getPassword().equals(loginRequest.getPassword())) throw new InvalidDetailsException(GenerateApiResponse.LOGIN_CREDENTIALS_IS_INVALID);
        sellerRepository.save(foundSeller);
        return GenerateApiResponse.loginSuccessful(GenerateApiResponse.LOGIN_SUCCESSFUL);

    }


    @Override
    public Seller findByEmail(String sellerEmailAddress) {
        return sellerRepository.findByEmailAddress(sellerEmailAddress);
    }

    private boolean checkIfUserExist(String emailAddress) {
        Seller foundSeller = sellerRepository.findByEmailAddress(emailAddress);
        return foundSeller != null;
    }
}
