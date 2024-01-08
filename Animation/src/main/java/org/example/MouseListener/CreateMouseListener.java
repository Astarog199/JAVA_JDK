package org.example.MouseListener;

import java.awt.event.MouseEvent;

public class CreateMouseListener {
   public void CreateMouseListener(MouseListener l, MouseEvent e) throws java.lang.Exception {

       if(1 == e.getButton()) {
           l.leftMouseButtonAction();
       } else if (3 == e.getButton()) {
           l.RightMouseButtonAction();
       }
    }
}


