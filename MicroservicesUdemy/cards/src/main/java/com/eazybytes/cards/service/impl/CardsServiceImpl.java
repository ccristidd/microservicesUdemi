package com.eazybytes.cards.service.impl;

import com.eazybytes.cards.constants.CardsConstants;
import com.eazybytes.cards.dto.CardsDto;
import com.eazybytes.cards.entity.Cards;
import com.eazybytes.cards.exceptions.CardAlreadyExistsException;
import com.eazybytes.cards.exceptions.ResourceNotFoundException;
import com.eazybytes.cards.mapper.CardsMapper;
import com.eazybytes.cards.repository.CardsRepository;
import com.eazybytes.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Primary
public class CardsServiceImpl implements ICardsService {
    private CardsRepository cardsRepository;

    /**
     * @param mobileNumber - Mobile Number of the Customer
     */
    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }

    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        Long randomCardNumber = 1_00_000_000_000L + new Random().nextInt(9_00_000_000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setMobileNumber(mobileNumber);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    /**
     * @param mobileNumber - Input mobile Number
     * @return Card Details based on a given mobileNumber
     */
    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        return CardsMapper.mapToCardsDto(card, new CardsDto());
    }

    /**
     * @param cardsDto - CardsDto Object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCard(CardsDto cardsDto) {
        Cards card = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "cardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, card);
        cardsRepository.save(card);
        return true;
    }

    /**
     * @param mobileNumber - Input Mobile Number
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        cardsRepository.delete(card);
        return !(cardsRepository.findByMobileNumber(mobileNumber).isPresent());

    }
}
