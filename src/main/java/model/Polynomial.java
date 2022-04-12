package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.*;
public class Polynomial {
    private List<Monomial> polynomial;

    public Polynomial()
    {
        polynomial = new ArrayList<Monomial>();
    }

    public List<Monomial> getMonomials() {
        return polynomial;
    }

    public void addMonomial(double coefficient, int grade) {
        if(coefficient != 0)
        {
            Monomial monomial = new Monomial(grade, coefficient);
            polynomial.add(monomial);
        }
    }

    @Override
    public String toString()
    {
        String s="<html><body>";
        for(Monomial monomial : polynomial)
        {
            if(monomial.getCoefficient() != 0) {
                if(monomial.getCoefficient() >= 0 && !monomial.equals(polynomial.get(0)))
                    s += "+";
                s += monomial;
            }
        }
        if(s == "<html><body>") s+="0";
        s+="</body></html>";
        return s;
    }

    public static boolean isValid(String input)
    {
        if(input.equals("")) return false;
        if(input.charAt(0)!='-') input = "+" + input;
        input = input.replace("-", "+-");
        final String POLYNOMIAL_PATTERN = "([+]([+-]?[0-9]*[.]?[0-9]*)?[*]?[x|X]?([\\^][0-9]+)?)+";
        Pattern pattern = Pattern.compile(POLYNOMIAL_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return Pattern.matches(POLYNOMIAL_PATTERN, input);
    }

    public void create(String input)
    {
        if(input.charAt(0)!='-') input = "+" + input;
        input = input.replace("-", "+-");
        final String POLYNOMIAL_PATTERN = "([+]([+-]?[0-9]*[.]?[0-9]*)?[*]?[x|X]?[\\^]?([0-9]+)?)";
        Pattern pattern = Pattern.compile(POLYNOMIAL_PATTERN);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find())
        {
            double coefficient;
            int grade;
            if(matcher.group(2).equals("")) coefficient = 1;
            else if(matcher.group(2).equals("-")) coefficient = -1;
            else
            {
                coefficient =Double.parseDouble(matcher.group(2));
            }
            if(matcher.group(3) == null)
            {
                if(matcher.group(1).contains("x") || matcher.group(1).contains("X"))
                {
                    grade = 1;
                }
                else
                {
                    grade = 0;
                }
            }
            else
            {
                grade = Integer.parseInt(matcher.group(3));
            }
            Monomial monomial = getMonomialByGrade(grade);
            if (monomial == null) {
                monomial = new Monomial(grade, coefficient);
                polynomial.add(monomial);
            }
            else
                monomial.setCoefficient(monomial.getCoefficient()+coefficient);
        }
        sortMonomials();
    }

    public void sortMonomials()
    {
        polynomial.sort(new Comparator<Monomial>() {
            @Override
            public int compare(Monomial o1, Monomial o2) {
                return o2.getGrade() - o1.getGrade();
            }
        });
    }

    public Monomial getMonomialByGrade(int grade)
    {
        for (Monomial monomial: polynomial) {
            if(monomial.getGrade() == grade)
                return monomial;
        }
        return null;
    }
}
