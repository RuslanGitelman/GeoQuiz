# Содержание
1. [Диаграмма вариантов использования](#1Диаграмма-вариантов-использования)  
1.1 [Актёры](#11-Актёры)  
1.2 [Варианты использования](#12-Варианты-использования)  
1.2.1 [Однопользовательская игра](#121-Начать-игру)  
1.2.2 [Многопользовательская игра](#122-Multiplayer)  
1.2.3 [Статистика](#123-Statistics)  
1.2.4 [Выход из игры](#124-Выход-из-игры)   
# 1. Диаграмма вариантов использования 
![Диаграмма-вариантов использования](https://github.com/RuslanGitelman/GeoQuiz/blob/master/Diagrams/Use%20Case/UseCaseUpdated.png) 
## 1.1 Актёры 
  Игрок - человек, который принимает участие в игровом процессе  

## 1.2 Варианты использования 
### 1.2.1 Однопользовательская игра  
Вариант использования "Play game in singleplayer mode" позволяет игроку начать однопользовательскую игру.  
Поток выполнения:
 1. Игрок нажимает на кнопку "Single quiz";
 2. Отображение игрового поля;
 3. Увеличение количества пройденных раундов на 1;
 4. Игрок выбрал один из вариантов ответа;
 5. Если игрок выбрал неправильный ответ, переход к пункту 7;
 6. Увеличение игрового счёта на 1;
 7. Если количество пройденных раундов меньше 5, переход к пункту 2;
 8. Если игровой счёт меньше 5, переход к пункту 11;
 9. Отображение экрана победы;
 10. Переход к пункту 12;
 11. Отображение экрана поражения;
 12. Конец.  
    
### 1.2.2 Многопользовательская игра
Вариант использования "Play game in multiplayer mode" предоставляет игроку возможность многопользовательской игры.  
Поток выполнения:  
 1. Игрок нажимает кнопку "Quiz with opponent";
 2. Если у игрока нет интернет подключения, смотрите "Альтернативный поток выполнения 1";
 3. Отображение меню мультиплеера;
 4. Если игрок нажимает кнопку "Back to menu", смотрите "Альтернативный поток выполнения 2";
 5. Если игрок нажимает кнопку "Join", смотрите "Альтернативный поток выполнения 3";
 6. Игрок нажимает кнопку "Create" для создания игровой комнаты;
 7. Игрок дожидается подключения противника;
 8. Игрок нажимает кнопку "Ready";
 9. Отображение игрового поля;
 10. Увеличение количества пройденных раундов на 1;
 11. Игрок выбрал один из вариантов ответа;
 12. Если игрок выбрал неправильный ответ, переход к пункту 14;
 13. Увеличение игрового счёта на 1;
 14. Если количество пройденных раундов меньше 5, переход к пункту 9;
 15. Если игровой счёт меньше 5, переход к пункту 18;
 16. Отображение экрана победы;
 17. Переход к пункту 19;
 18. Отображение экрана поражения и игрового счёта;
 19. Конец.
 
Альтернативный поток выполнения 1: 
 1. Игрок нажимает кнопку "Quiz with opponent";
 2. У игрока нет интернет подключения и новое меню не появляется, оставляя игрока в главном меню;
 3. Конец.

Альтернативный поток выполнения 2:
 1. Игрок нажимает кнопку "Quiz with opponent";
 2. Если у игрока нет интернет подключения, смотрите "Альтернативный поток выполнения 1";
 3. Отображение меню мультиплеера;
 4. Игрок нажимает кнопку "Back";
 5. Отображение главного меню;
 6. Конец.
 
Альтернативный поток выполнения 3: 
 1. Игрок нажимает кнопку "Quiz with opponent";
 2. Если у игрока нет интернет подключение, смотрите "Альтернативный поток выполнения 1";
 3. Отображение меню мультиплеера;
 4. В этом меню игрок нажимает кнопку "Join" для присоединения к игровой комнате;
 5. Если нет игровой комнаты, переход к пункту 3;
 6. Подключение игрока к игровой комнате;
 7. Игрок нажал кнопку Ready;
 8. Отображение игрового поля;
 9. Игрок выбрал один из вариантов ответа;
 10. Увеличение количества пройденных раундов на 1;
 11. Если игрок выбрал неправильный ответ, переход к пункту 13;
 12. Увеличение игрового счёта на 1;
 13. Если количество пройденных раундов меньше 5, переход к пункту 8;
 14. Если игровой счёт меньше 5, переход к пункту 17;
 15. Отображение экрана победы;
 16. Переход к пункту 18;
 17. Отображение экрана поражения и игрового счёта;
 18. Конец.

### 1.2.3 Статистика игрока  
Вариант использования "Statistics" позволяет игроку просматривать свою статистику на основе его игр.  
Поток выполнения:
 1. Игрок нажимает на кнопку "Statistics" в главном меню;
 2. Открывается статистика;
 3. Конец.  
  
### 1.2.4 Выход из игры 
Вариант использования "Exit" позволяет игроку выйти из игры.
Поток выполнения:
 1. Игрок нажимает на кнопку "Exit";
 2. Выход из игры;
 3. Конец.
