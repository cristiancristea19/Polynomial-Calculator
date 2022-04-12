package controller;
import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view ;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String input1 = view.getFirstPolynomial();
        String input2 = view.getSecondPolynomial();
        if(source == view.getAddBtn() || source == view.getSubBtn() || source == view.getMultBtn() || source == view.getDivBtn())
        {
            operationsWithTwoPolynomials(source, input1, input2);
        }
        else
        {
            operationsWithOnePolynomial(source, input1, input2);
        }
    }


    private void operationsWithOnePolynomial(Object source, String input1, String input2)
    {
        if(source == view.getDerivBtn1())
        {
            if(Polynomial.isValid(input1) == true)
            {
                callDerive(input1);
            }
            else
            {
                view.warning("Incorrect format of the first polynomial.");
            }
        }
        else if(source == view.getDerivBtn2())
        {
            if(Polynomial.isValid(input2) == true)
            {
                callDerive(input2);
            }
            else
            {
                view.warning("Incorrect format of the second polynomial.");
            }
        }
        else if(source == view.getIntBtn1())
        {
            if(Polynomial.isValid(input1) == true)
            {
                callIntegrate(input1);
            }
            else
            {
                view.warning("Incorrect format of the first polynomial.");
            }
        }
        else if(source == view.getIntBtn2())
        {
            if(Polynomial.isValid(input2) == true)
            {
                callIntegrate(input2);
            }
            else
            {
                view.warning("Incorrect format of the second polynomial.");
            }
        }
    }

    private void callDerive(String input)
    {
        Polynomial polynomial = new Polynomial();
        polynomial.create(input);
        Polynomial result = Operations.derive(polynomial);
        view.showResults(result.toString());
    }

    private void callIntegrate(String input)
    {
        Polynomial polynomial = new Polynomial();
        polynomial.create(input);
        Polynomial result = Operations.integrate(polynomial);
        view.showResults(result.toString());
    }

    private void operationsWithTwoPolynomials(Object source, String input1, String input2)
    {
        if(Polynomial.isValid(input1) == false)
        {
            view.warning("Incorrect format of the first polynomial.");

        }
        else if(Polynomial.isValid(input2) == false)
        {
            view.warning("Incorrect format of the second polynomial.");
        }
        else
        {
            Polynomial polynomial1 = new Polynomial();
            Polynomial polynomial2 = new Polynomial();
            polynomial1.create(input1);
            polynomial2.create(input2);
            if(source == view.getAddBtn())
            {
                Polynomial result = Operations.add(polynomial1, polynomial2);
                view.showResults(result.toString());
            }
            else if(source == view.getSubBtn())
            {
                Polynomial result = Operations.substract(polynomial1, polynomial2);
                view.showResults(result.toString());
            }
            else if(source == view.getMultBtn())
            {
                Polynomial result = Operations.multiply(polynomial1, polynomial2);
                view.showResults(result.toString());
            }
            else if(source == view.getDivBtn())
            {
                Polynomial[] results = Operations.divide(polynomial1, polynomial2);
                view.showResults(results[0].toString(), results[1].toString());
            }
        }
    }
}
