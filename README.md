Практическая работа №2 Приложение на Spring

Выполнили студенты 6132-010402D Старыгин Виталий, Ненашев Данила

```
IntelliJ IDEA Ultimate

OpenJDK 17.0.15
```
```
Предметная область - система управления задачами

Сущности: пользователь (User), задача (Task)
```
СУБД PostgreSQL

Скрипт для создания и заполнения базы данных:
```
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(128) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    age INTEGER NOT NULL CHECK (age >= 18 AND age <= 75)
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    created_date DATE NOT NULL DEFAULT CURRENT_DATE,
    completed BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO users (name, email, age) VALUES 
('Старыгин Виталий', 'vs@mail.ru', 22),
('Ненашев Данила', 'nd@gmail.com', 22),
('Иванов Иван', 'ii@yandex.ru', 18),
('Петров Петр', 'pp@inbox.ru', 75);

INSERT INTO tasks (title, user_id, created_date, completed) VALUES 
('Написать код программы', 1, '2025-10-20', false),
('Протестировать код программы', 2, '2025-10-21', false),
('Написать фидбек', 2, '2025-10-22', false),
('Написать README', 3, '2025-10-23', false);
```
Реализовано добавление, удаление, редактирование пользователей и задач

<img width="1920" height="994" alt="{AD1C90A7-A814-40EA-9E06-5E85FDC8F963}" src="https://github.com/user-attachments/assets/e150aa3f-f896-441d-b6fa-e02730632ea2" />

<img width="1919" height="995" alt="{56F5A6FC-F9F7-4942-98C2-32496A87C2EB}" src="https://github.com/user-attachments/assets/bfa3fa01-0645-4274-a6b8-57a05e79d837" />

<img width="1918" height="993" alt="{50D02EBD-8A2B-4B43-9BB1-A8514DACD155}" src="https://github.com/user-attachments/assets/0b25f346-6b76-45de-a3cf-ac832c6fe76c" />

<img width="1917" height="319" alt="{01905EEE-A427-4E6F-927A-ACB2638B3733}" src="https://github.com/user-attachments/assets/86c3ebd9-6ce4-4be9-99c9-8bc3865c9222" />

<img width="1915" height="594" alt="{429BFE9B-103A-4710-90C0-B864204304A0}" src="https://github.com/user-attachments/assets/6f837911-4e29-4b12-b8fb-c3ba8a6b65e6" />

<img width="1920" height="626" alt="{EDB838DB-256F-4CF1-B3FA-0C13F35497A5}" src="https://github.com/user-attachments/assets/bcec566f-841f-4334-94d2-58d983698d36" />

<img width="1920" height="651" alt="{9E68D8CF-437A-48E5-8333-4396819F96A7}" src="https://github.com/user-attachments/assets/39741ad2-2246-4496-b9a6-8516349e2254" />

<img width="1920" height="622" alt="{639F1ECB-D904-46A5-AB2D-094E047B9841}" src="https://github.com/user-attachments/assets/ab13f506-811e-44b8-84a7-02667acb932b" />

<img width="1920" height="782" alt="{52E17C1E-DBE6-41BB-8340-E555E2FD7E8F}" src="https://github.com/user-attachments/assets/61ad78c9-1613-4e11-bb08-66dad28925e2" />

<img width="1920" height="691" alt="{9B9072F5-3952-4B71-B43C-6A227D7A493B}" src="https://github.com/user-attachments/assets/a7ce442d-0017-4d17-9bcd-ec3dad7cb988" />

<img width="1918" height="631" alt="{959405DC-BE48-4E0F-B369-64F77B9A7342}" src="https://github.com/user-attachments/assets/62a725f3-37b5-408f-ac37-e575254eb7d5" />

<img width="1920" height="557" alt="{F493EEA2-78F5-4D21-8727-1BC21FC4D82D}" src="https://github.com/user-attachments/assets/a945b992-4b86-4fa4-8cb0-53a398d4879c" />

<img width="1914" height="596" alt="{3AF32B7F-7B83-47AE-BC4F-2FC643048046}" src="https://github.com/user-attachments/assets/9ecdfe42-b753-48e0-99d5-4a4fc3f40411" />

<img width="1920" height="548" alt="{D13C29AE-433B-4B8F-A1C3-3EC502CA01E0}" src="https://github.com/user-attachments/assets/7df3e05f-7dd1-48b5-9801-3306088436a0" />

<img width="1920" height="598" alt="{29284BF9-D4B3-4802-8DE6-B42CAB698B4E}" src="https://github.com/user-attachments/assets/075e509e-907d-456e-9ef2-039578b03527" />




