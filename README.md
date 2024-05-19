# CS151-PlayStation-Network-Account-Model
CS151 Project
• Project title: PlayStation Network Account Model

• Team #, team members 
Project 1, Jake Doxey, David Huyng, Nam Nguyen

• Project Contributions and Issues: 

David Huyng: 

Jake Doxey: 

• Developed the start screen with navigation to the signup and login screen. 

• Created the signup screen with error checking. The program throws exceptions if the username field is empty, the username already exists in the database, the email field is empty, and/or the email field doesn’t contain the ‘@’ symbol. For the password requirements, I made it so the password requires a lowercase letter, an uppercase letter, a special character, and a length of at least 8 characters.

• Designed the login screen for user authentication. You can login with either your created account or with an account already in the database. 

• Created the leaderboard screen that shows the top 5 players with the highest level in the database. Your currently logged in account will be shown at the bottom of the list compared to the leaderboards. I had help with Nam on this page implementing the top 5 users being shown on the page. 

• Modified the UI of the home screen to look more clean and match the theming of the other screens I developed. I will show before and after pictures of the home screen showing my modifications.

![originalhome](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/24424867/46b70aee-72ec-41a4-9f0f-89802b06d1c9)

 <img width="595" alt="newhome" src="https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/24424867/b7a43964-401a-4127-8857-b7183a8db626">
 
• Although I mostly focused on developing the UI for the project, while developing the front end I needed to make some modifications to the backend to fit my needs. One example of this is modifying the accountmanager class to be a singleton. I did this so there would only be one instance of accountmanager that I could use to login to the account. This singleton was also used for the leaderboards.
<img width="515" alt="amsingleton" src="https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/24424867/de5fb393-faca-47e8-854e-e1bf7661ecd3">

• Another thing I added was a utility function for throwing errors. I did this so I could follow the DRY concept. If I didn’t add the utility function I would have had to rewrite the code for both the signup and login pages
<img width="691" alt="utility" src="https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/24424867/ddef1967-e83d-41d7-af9e-913437e1652d">

• Some issues I faced during the creation of this project was implementing custom fonts and implementing audio clips into button presses. The font was specifically going to be used on the leaderboard screen to match the Persona 5 theming (a video game). I ended up having issues with using the css file in my FXML file. I couldn’t figure out how to get it to work. I also wanted to use a persona 5 audio clip each time a button was clicked to add a more tactile feel. This introduced a whole suite of problems so I decided to cut this feature in the final version. 

Nam Nguyen: 
- So the original idea is for me to do a lot of that back-end stuff. I did some like changing the implementation of the leaderboard and setting features like a friendlist for future implementation. I don't know how to work on the API stuff so I step away from finishing the back end and try to help on the front end. This is where I have a little more knowledge than our other back-end members so I help with the front-end development.

- In the back end I developed: Friendlist, Leaderboard sorting, and implementation, and I also worked on leveling up systems that haven't being able to implement.

- In the front end I developed: The basis of the homepage this is just a rough UI making. I developed the friends page (Still in development), InfoPage shows your account, and the search page that searches for the game that is available. I also help on getting the leaderboard fully implemented. This mainly because we never really got a way to incorporated our API and the main program before. So I think I able to figure something out to incorporate the leaderboard when the account get added to the AccountManager. Jake Doxey do you have the full credit on the creation of the UI of the leaderboard page, I was just really only work on the back end of that page in order for it to work and show the account, and the ranking of the account. So yeah pretty much for the front end stuff I was pretty much in charge of encorporate the backend and the front-end element in order for the project to display our object and use the back end implementation. 

- So yeah I do run into multiple problems during the implementation of all the previously mentioned items like the fact that we still haven't able to get friend invitation working due to the fact that I will require me to change the implement of the friend list completely and needed to put it as an element of Account. plus the fact so far our API don't really have a friendlist in mind so a creation of friendlist would required an update of the Initializing code of the API. These are the problems that haven't been solved.

- There are multiple features that have been cut due to time constraints like Friendlist or the saving data feature. There is also a bugged on the search feature where if you search a game twice it would break(No solution have been found)


• State the problem/issue to resolve
The issue to be resolved is a way to keep track of your PlayStation Account. This includes a friends list, a trophy list, an account level based on your trophies, etc….

• If applicable, briefly survey previous works if any (include references) 
N/A

• If applicable, describe assumptions / operating environments / intended usage 
The assumption will be that the user plays games to which we can award trophies that are attached to said account. The operation environment will be in the playstation environment, an application that is meant to supplement the experience of playing on a game system. The intended usage is to allow the user to view both information regarding the activity of the player (accumulated trophies) as well as others.

• High-level description of your solution which may include (but is not limited to), your plan and approach.  Be as specific as possible. 
At a high level, I want to have an account be the parent class for all of the subclasses. The subclasses can possibly include different account types like “private friends list”, “private trophy list” “public everything” etc. I would have a class with static methods for the leaderboard so it can be accessed and updated without instantiating objects. I would also have to implement some method to calculate the account level based on the trophies earned from the account. If we are to replicate the trophy levels on real PSN accounts, this could be complex as the levels scale in points needed to level up. To make our program user-friendly, we will implement our account system using JavaFX, so users don’t have to type into the terminal and can have a visual representation of their account. In terms of adding achievements, we would have a database of games and their corresponding trophy lists. We would have methods that set trophies to be earned.

• Functionality: describe how your solution tackles the issues 
The solution to the issue is to implement an account system that keeps track of games in your library, your trophies, your account level (based on trophies), and your friends list. I would also like to implement different settings to set the visibility of things such as games, trophies, and friends lists to private.

• Operations: List operations for each intended user (in list format).  Be precise and specific. 
User:
They can create an account with a login in and out function
View there own profiles that that have the game list pre-created. 
View the game that is available in our library
View leaderboard 
System:
Stores/maintains account information
Adding trophies
Viewing trophies
Add point values to trophies

Step to run!
- To run this program you need to add the -vm option of the Javafx to the run config
and you pretty much just run by clicking compile. 
- In order for you to login you will need to created an account or use the premake account( This is a premake Account username: Max Account passwords: Maxuser!lol1! (this program is kinda case sentive to coppies exactly as you see with trim()) You should see the home page and from there there 3 option by login out click on the playstation icon. View your profile and search for game. by clicking on the view profile button, and search game button in the info page. And lastly View the leaderboard. to return to home from any of these pages just click the red buttons.

This is the runnable program!
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/565d4a32-5b5e-47db-a12c-174ac5387e1d)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/ab45cf5c-85d0-4568-9766-58729b1a014f)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/42f46046-6443-4e70-86ea-c548df33e64b)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/53226f50-b505-4a4e-8040-273ad81bdce9)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/c9b2cb2b-14c6-4061-9e2d-c2325e4a6f73)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/ffe6d47b-1436-478d-8181-10d8ed1033eb)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/9e0a9ede-837c-47b8-935e-8fa6167def92)
![image](https://github.com/DavidHuynh04/CS151-PlayStation-Network-Account-Model/assets/108606639/197325ba-1dff-4211-9f04-d7059e93d333)





 
• (Optional) References: must include citations in content using the format [1], [2], etc. 
N/A
