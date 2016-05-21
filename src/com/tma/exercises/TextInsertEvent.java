package com.tma.exercises;

import javax.swing.*;

/**
 * @author Jesper Buus Nielsen
 */
public class TextInsertEvent extends MyTextEvent {

    private String text;

    public TextInsertEvent(int offset, String text) {
        super(offset);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    void perform(JTextArea area) {
        area.insert(getText(), getOffset());
    }

    @Override
    void undo(JTextArea area) {
        area.replaceRange(null, getOffset(), getOffset() + getText().length());
    }

    @Override
    public String toString() {
        return String.format("Insert '%s': %s", text, super.toString());
    }
}

