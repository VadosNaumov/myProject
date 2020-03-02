# myProject

CRUD приложение.

В рамках проекта выполнено: 
установка зависимостей, сборка (Apache Maven), подключение Spring Boot(data-jpa, web, thymeleaf), подключение к базам данных(postgresql), создание html-страниц.

Создаем БД и устанавливаем взаимосвязи:
-страны,
-города,
-юзеры,
-банки,
-аккаунты,
-компании,
-платежи.

Создаем объектные представления сущностей из нашей БД (в папке model). После создаем соответствующие интерфейсы для взаимодействия с БД(папка repository). Далее создаем обертку над репозиторием - service, который принимает запросы из внешнего мира и дергает репозиторные методы. После создаем контроллеры, которые связывают страницы с нашим функционалом.

Позволяем пользователю создавать, редактировать, удалять, получать записи из всех БД.
