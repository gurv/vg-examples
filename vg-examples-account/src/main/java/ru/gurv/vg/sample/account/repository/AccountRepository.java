package ru.gurv.vg.sample.account.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.gurv.vg.sample.account.domain.Account;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
