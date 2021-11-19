package ru.job4j.stremapi.bank;

import java.util.*;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        Optional<User> userSearch = findByPassport(passport);
        if (userSearch.isPresent()) {
            List<Account> userAccounts = users.get(userSearch.get());
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> rsl = Optional.empty();
        Optional<User> userSearch = findByPassport(passport);
        if (userSearch.isPresent()) {
            return users.get(userSearch.get())
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && destAccount.isPresent()) {
            if (srcAccount.get().getBalance() >= amount) {
                destAccount.get().setBalance(destAccount.get().getBalance() + amount);
                srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
                return true;
            }
        }
        return false;
    }
}
