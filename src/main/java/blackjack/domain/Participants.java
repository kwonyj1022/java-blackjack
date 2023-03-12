package blackjack.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<Person> participants = new ArrayList<>();

    public Participants(Dealer dealer, List<Player> players) {
        this.participants.add(dealer);
        this.participants.addAll(players);
    }

    public Person findByName(String name) {
        return participants.stream()
                .filter(person -> person.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 이름과 일치하는 참가자가 없습니다."));
    }

    public int getPlayerScore(String name) {
        return findByName(name).getScore();
    }

    public Person getDealer() {
        return participants.stream()
                .filter(Person::isDealer)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 딜러가 없습니다."));
    }

    public String getDealerName() {
        return getDealer().getName();
    }

    public List<Card> getDealerInitCard() {
        return getDealer().getInitCards();
    }

    public int getDealerScore() {
        return getDealer().getScore();
    }

    public List<Player> getPlayers() {
        return participants.stream()
                .filter(Person::isPlayer)
                .map(Player.class::cast)
                .collect(toList());
    }

    public List<Person> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<Card> getCardsByName(String name) {
        return findByName(name).getCards();
    }
}
