# Содержание
1. [Диаграмма вариантов использования](#1Диаграмма-вариантов-использования)  
1.1 [Актёры](#11-Актёры)  
1.2 [Варианты использования](#12-Варианты-использования)  
1.2.1 [Начать игру](#121-Начать-игру)  
1.2.2 [Многопользовательская игрa](#122-Multiplayer)  
1.2.3 [Статистика](#123-Statistics)  
1.2.4 [Выход из игры](#124-Выход-из-игры)   
# 1. Диаграмма вариантов использования 
![Диаграмма-вариантов использования](https://github.com/RuslanGitelman/GeoQuiz/blob/master/Diagrams/Use%20Case/UseCase.png) 
## 1.1 Актёры 
  Игрок - человек, который принимает участие в игровом процессе  

## 1.2 Варианты использования 
### 1.2.1 Начать игру  
Вариант использования "Play game" позволяет игроку начать игру.  
Поток выполнения:
 1. Игрок нажимает на кнопку "Singleplayer";
 2. Игрок выбирает сложность;
 3. Игрок нажимает на кнопку "Start"
 4. Начинается игровой процесс;
 5. Конец.  
 
 Альтернативный поток выполнения: 
 1. Игрок нажимает на кнопку "Singleplayer";
 2. Игрок нажимает кнопку назад;
 3. Конец
 
 ### 1.2.2 Выход из игры 
 Вариант использования "Exit" позволяет игроку выйти из игры.
 Поток выполнения:
  1. Игрок нажимает на кнопку "Exit";
  2. Выход из игры;
  3. Конец.
  
 ### 1.2.3 FAQ  
 Вариант использования "FAQ" позволяет игроку открыть пользовательское руководство.  
 Поток выполнения:
  1. Игрок нажимает на кнопку "FAQ" в главном меню;
  2. Открывается руководство;
  3. Конец.  
    
 ### 1.2.4 Statistics  
 Вариант использования "Statistics" позволяет игроку просматривать свою статистику на основе его игр.  
 Поток выполнения:
  1. Игрок нажимает на кнопку "Statistics" в главном меню;
  2. Открывается статистика;
  3. Конец.  
  
### 1.2.5 Multiplayer
Вариант использования "Multiplayer" предоставляет игроку возможность многопользовательской игры.  
Поток выполнения:  
 1. Игрок нажимает кнопку "LAN";
 2. Если у игрока есть интернет подключение то появляется новое меню;
 3. В этом меню игрок нажимает кнопку "Create" для создания игровой комнаты;
 4. Игрок выбирает сложность и дожидается подключения противника;
 5. Начинается игровой процесс;
 6. Конец.  

Альтернативный поток выполнения: 
 1. Игрок нажимает кнопку "LAN";
 2. У игрока нет интернет подключения и новое меню не появляется, оставляя игрока в главном меню;
 3. Конец. 
 
 Альтернативный поток выполнения: 
 1. Игрок нажимает кнопку "LAN";
 2. Если у игрока есть интернет подключение то появляется новое меню;
 3. В этом меню игрок нажимает кнопку "Join" для присоединения к игровой комнате;
 4. Игрок подключается к комнате и начинается игровой процесс;
 5. Конец.  
 