## try-vaadin
![Иллюстрация к проекту](https://www.tmssoftware.com/site/img/webcore/vaadin.png)

## Тестовое задание

### Необходимо используя Фреймворк Vaadin версии 14 реализовать 2 странички

## 1. Сделать форму вида:

Заголовок

Поле А [.     ]

Поле Б [.     ]

Выпадающий список [.     ]| |

Сохранить отменить

[.   ] - это input поля для ввода текста


В Поле  Б данные должны скрываться *** (как при вводе пароля)
Для выпадающего списка показать значения из enum SelectedValues , в нем будут Значения: Да, Нет, Не знаю

## 2. При нажатии на кнопку “сохранить” показывать модальное окно в котором будет сообщение (Вы сохранили данные) и кнопка “закрыть”

### После нажатия на закрыть показывать на экране JSON из 3х параметров, вида:

{
“fieldA”: “ … “,
“fieldB”: “ … “,
“Select”: “ …. "
“Save”: OK
}
