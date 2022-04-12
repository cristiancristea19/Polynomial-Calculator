package model;

import java.util.Objects;

public class Monomial {
    private int grade;
    private double coefficient;

    public Monomial(int grade, double coefficient)
    {
        this.grade = grade;
        this.coefficient = coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monomial monomial = (Monomial) o;
        return grade == monomial.grade && Double.compare(monomial.coefficient, coefficient) == 0;
    }


    @Override
    public String toString() {
        String coeff = "";
        String exponent = "";
        if(coefficient == 0)
            return "";
        if(coefficient == -1) coeff = "-";
        if(coefficient != 1 && coefficient != -1) {
            if((int)coefficient == coefficient)
                coeff = (int)coefficient + "";
            else
                coeff = String.format("%.2f", coefficient);
        }
        else if(grade == 0)
        {
            coeff = (int)coefficient + "";
        }
        if(grade == 1)
        {
            exponent = "x";
        }
        else if(grade != 0)
        {
            exponent = "x<sup>" + grade + "</sup>";
        }
        return coeff+exponent;
    }
}

