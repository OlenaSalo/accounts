package com.epam.lab.accounts.accounts.converter;

import com.epam.lab.accounts.accounts.dto.TransactionDTO;
import com.epam.lab.accounts.accounts.model.TransactionModel;
import com.google.common.base.Preconditions;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter implements Converter<TransactionModel, TransactionDTO> {

    @Override
    public TransactionDTO convert(TransactionModel source) {
        Preconditions.checkNotNull(source);
        final TransactionDTO target = new TransactionDTO();
        target.setFromAccountCode(source.getFromAccount().getCode());
        target.setFromAccountName(source.getFromAccount().getName());
        target.setToAccountCode(source.getToAccount().getCode());
        target.setToAccountName(source.getToAccount().getName());
        target.setValue(source.getValue());
        target.setFromCurrentBalance(source.getFromCurrentBalance());
        target.setToCurrentBalance(source.getToCurrentBalance());
        target.setFromTargetBalance(source.getFromTargetBalance());
        target.setToTargetBalance(source.getToTargetBalance());
        return target;
    }
}
