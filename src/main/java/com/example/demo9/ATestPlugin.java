package com.example.demo9;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import java.text.NumberFormat;

import static org.apache.commons.lang3.StringUtils.isNumeric;

public class ATestPlugin extends AnAction{
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        String[] options = new String[] {"Close"};

        Editor a = e.getData(CommonDataKeys.EDITOR);
        String text = a.getSelectionModel().getSelectedText();

        if(isNumeric(text)) {
            Messages.showDialog(NumberFormat.getInstance().format(Integer.parseInt(text)), "Number Helper", options, 0, Messages.getInformationIcon());
        }
    }

    @Override
    public boolean isDumbAware() {
        return super.isDumbAware();
    }
}
