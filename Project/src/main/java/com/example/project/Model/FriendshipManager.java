package com.example.project.Model;

import java.util.*;

public class FriendshipManager {
    private final Map<String, Set<String>> friendships;

    public FriendshipManager() {
        this.friendships = new HashMap<>();
    }

    public void addFriendship(String user1, String user2) {
        friendships.computeIfAbsent(user1, k -> new HashSet<>()).add(user2);
        friendships.computeIfAbsent(user2, k -> new HashSet<>()).add(user1);
    }

    public void removeFriendship(String user1, String user2) {
        Set<String> friendsOfUser1 = friendships.get(user1);
        Set<String> friendsOfUser2 = friendships.get(user2);
        if (friendsOfUser1 != null) {
            friendsOfUser1.remove(user2);
        }
        if (friendsOfUser2 != null) {
            friendsOfUser2.remove(user1);
        }
    }

    public Set<String> getFriends(String userName) {
        return friendships.getOrDefault(userName, Collections.emptySet());
    }
}
