# CS151-PlayStation-Network-Account-Model
CS151 Project
• Project title: PlayStation Network Account Model

• Team #, team members 
Project 1, Jake Doxey, David Huyng, Nam Nguyen

• Team members working on the proposal 
All

• State the problem/issue to resolve
The issue to be resolved is a way to keep track of your PlayStation Account. This includes a friends list, a trophy list, an account level based on your trophies, etc….

• If applicable, briefly survey previous works if any (include references) 
N/A

• If applicable, describe assumptions / operating environments / intended usage 
The assumption will be that the user plays games to which we can award trophies that are attached to said account. The operation environment will be in the playstation environment, an application that is meant to supplement the experience of playing on a game system. The intended usage is to allow the user to view both information regarding the activity of the player (accumulated trophies) as well as others.

• High-level description of your solution which may include (but is not limited to), your plan and approach.  Be as specific as possible. 
At a high level, I want to have an account be the parent class for all of the subclasses. The subclasses can possibly include different account types like “private friends list”, “private trophy list” “public everything” etc. I would have a class with static methods for the leaderboard so it can be accessed and updated without instantiating objects. I would also have to implement some method to calculate the account level based on the trophies earned from the account. If we are to replicate the trophy levels on real PSN accounts, this could be complex as the levels scale in points needed to level up. To make our program user-friendly, we will implement our account system using javafx, so users don’t have to type into the terminal and can have a visual representation of their account. In terms of adding achievements, we would have a database of games and their corresponding trophy lists. We would have methods that set trophies to earned.

• Functionality: describe how your solution tackles the issues 
The solution to the issue is to implement an account system that keeps track of games in your library, your trophies, your account level (based on trophies), and your friends list. I would also like to implement different settings to set the visibility of things such as games, trophies, and friends lists to private.

• Operations: List operations for each intended user (in list format).  Be precise and specific. 
User:
They can create an account with a login in and out function
View trophies and level
View leaderboard 
Add friends/remove friend/block
View friend trophies and level
Add games to your library
Adjust account settings
System:
Stores/maintains account information
Adding trophies
Viewing trophies
Add point values to trophies

• (Optional) References: must include citations in content using the format [1], [2], etc. 
N/A
