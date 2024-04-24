package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WidgetTest {
    Widget testWidget = Widget.builder()
            .id(1)
            .name("WidgetName")
            .build();

    @Test
    void getName() {
        String name = testWidget.getName();
        assertThat(name).isEqualTo("WidgetName");
    }

    @Test
    void getId() {
        int id = testWidget.getId();
        assertThat(id).isEqualTo(1);
    }

    @Test
    public void widgetBuilder() {
        Widget.WidgetBuilder widgetBuilder = testWidget.toBuilder();
        Widget newWidget = widgetBuilder.id(2).build();

        assertThat(newWidget.getName()).isEqualTo("WidgetName");
        assertThat(newWidget.getId()).isEqualTo(2);
    }

}