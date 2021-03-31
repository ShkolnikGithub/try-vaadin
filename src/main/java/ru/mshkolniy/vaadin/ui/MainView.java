package ru.mshkolniy.vaadin.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import ru.mshkolniy.vaadin.model.Response;
import ru.mshkolniy.vaadin.model.SelectedValues;
import ru.mshkolniy.vaadin.util.JSONParser;

@Push
@Route("")
public class MainView extends VerticalLayout {
    private final TextField fieldA = new TextField("Поле А");
    private final PasswordField fieldB = new PasswordField("Поле Б");
    private final ComboBox<SelectedValues> selectedValues = new ComboBox<>("Выпадающий список",
            SelectedValues.getAllAnswers());
    private final HorizontalLayout horizontalLayout = new HorizontalLayout();
    private final Dialog successfulSave = new Dialog(new Text("Вы сохранили данные"));
    private static final String SAVE = "ОК";
    private Response response = new Response();

    private final Button save = new Button("Сохранить");
    private final Button cancel = new Button("Отменить");
    private final Button close = new Button("Закрыть");

    public MainView() {
        add(createTitle("Заголовок"));
        add(createForm());
    }

    private Component createTitle(String title) {
        return new H3(title);
    }

    private Component createForm() {
        VerticalLayout formLayout = new VerticalLayout();
        fieldA.addValueChangeListener(event -> response.setFieldA(event.getValue()));
        fieldB.addValueChangeListener(event -> response.setFieldB(event.getValue()));
        selectedValues.addValueChangeListener(event -> response.setSelectedValue(event.getValue()));
        response.setSave(SAVE);

        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        successfulSave.setModal(true);
        successfulSave.setResizable(true);

        successfulSave.add(new Div(close));
        horizontalLayout.add(save, cancel);

        save.addClickListener(event -> successfulSave.open());
        cancel.addClickListener(event -> {
            fieldA.clear();
            fieldB.clear();
            selectedValues.clear();
        });
        close.addClickListener(event -> {
            successfulSave.close();
            add(JSONParser.getJson(response));
        });

        formLayout.add(fieldA, fieldB, selectedValues, horizontalLayout);

        return formLayout;
    }
}
