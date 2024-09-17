package com.example.demo4;

import javafx.application.Platform;
import javafx.scene.text.Text;

public class TextAnimator implements Runnable {

    private final Text textArea;
    private String text;
    private final int time;

    public TextAnimator(Text textArea, int time) {
        this.textArea = textArea;
        this.time = time;

    }

    @Override
    public void run() {
        try {
            while (true) {
                if (textArea.getText().trim().length() == 0) {
                    text = "blink blink";
                } else {
                    text = "";
                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        textArea.setText(text);
                    }
                });
                Thread.sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
