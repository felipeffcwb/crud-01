package com.api.crud01.services.client;

import com.api.crud01.entities.client.Client;
import com.api.crud01.enums.ClientType;
import com.api.crud01.utils.DocumentMessages;
import com.api.crud01.utils.DocumentValidator;
import com.api.crud01.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;

public class ClientFacade implements Utils, DocumentValidator {

    public boolean clientIsEmptyOrNull(Client client) {
        return client == null;
    }

    @Override
    public String isDocumentOk(String document) {
        if (stringIsNullOrEmpty(document)) {
            return DocumentMessages.MINOR_THEN_ELEVEN;
        }

        if (document.matches("[0-9]+") && document.length() != 11) {
            return DocumentMessages.MINOR_THEN_ELEVEN;
        }

        if (!documentValidate(document)) {
            return DocumentMessages.INVALID_DOCUMENT;
        }

        return DocumentMessages.OK;
    }

    @Override
    public boolean stringIsNullOrEmpty(String param) {
        return null == param || param.isEmpty();
    }

    @Override
    public boolean documentValidate(String document) {
        if (document.equals("00000000000") ||
                document.equals("11111111111") ||
                document.equals("22222222222") || document.equals("33333333333") ||
                document.equals("44444444444") || document.equals("55555555555") ||
                document.equals("66666666666") || document.equals("77777777777") ||
                document.equals("88888888888") || document.equals("99999999999") ||
                (document.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (document.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (document.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            if ((dig10 == document.charAt(9)) && (dig11 == document.charAt(10)))
                return (true);
            else return (false);
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public Strategy verifyClientType(ClientType type) {
        Strategy strategy;
        switch (type) {
            case PEOPLE:
                strategy = new PeopleClientStrategy();
                return strategy;
            default:
                break;
        }
        return null;
    }
}
