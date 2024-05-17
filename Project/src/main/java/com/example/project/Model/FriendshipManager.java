package com.example.project.Model;

import java.util.*;

public class FriendshipManager {
    private final Map<String, Set<Account>> friendships;

    public FriendshipManager() {
        this.friendships = new HashMap<>();
    }

    public void addFriendship(Account user1, Account user2) {
        friendships.computeIfAbsent(user1.getUserName(), k -> new HashSet<>()).add(user2);
        friendships.computeIfAbsent(user2.getUserName(), k -> new HashSet<>()).add(user1);
    }

    public void removeFriendship(Account user1, Account user2) {
        Set<Account> friendsOfUser1 = friendships.get(user1.getUserName());
        Set<Account> friendsOfUser2 = friendships.get(user2.getUserName());
        if (friendsOfUser1 != null) {
            friendsOfUser1.remove(user2);
        }
        if (friendsOfUser2 != null) {
            friendsOfUser2.remove(user1);
        }
    }

    public Set<Account> getFriends(String userName) {
        return friendships.getOrDefault(userName, Collections.emptySet());
    }
}
