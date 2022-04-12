package model;
public class Operations {
    public static Polynomial add(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        int i=0;
        int j=0;
        while(i != polynomial1.getMonomials().size() && j != polynomial2.getMonomials().size())
        {
            int grade1 = polynomial1.getMonomials().get(i).getGrade();
            int grade2 = polynomial2.getMonomials().get(j).getGrade();
            double coefficient1 = polynomial1.getMonomials().get(i).getCoefficient();
            double coefficient2 = polynomial2.getMonomials().get(j).getCoefficient();
            if(grade1 == grade2)
            {
                result.addMonomial( coefficient1 + coefficient2, grade1);
                i++;
                j++;
            }
            else if(grade1 > grade2)
            {
                result.addMonomial(coefficient1, grade1);
                i++;
            }
            else
            {
                result.addMonomial(coefficient2, grade2);
                j++;
            }
        }

        while(i != polynomial1.getMonomials().size())
        {
            result.addMonomial(polynomial1.getMonomials().get(i).getCoefficient(), polynomial1.getMonomials().get(i).getGrade());
            i++;
        }

        while(j != polynomial2.getMonomials().size())
        {
            result.addMonomial(polynomial2.getMonomials().get(j).getCoefficient(), polynomial2.getMonomials().get(j).getGrade());
            j++;
        }
        return result;
    }

    public static Polynomial substract(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        int i=0;
        int j=0;
        while(i != polynomial1.getMonomials().size() && j != polynomial2.getMonomials().size())
        {
            int grade1 = polynomial1.getMonomials().get(i).getGrade();
            int grade2 = polynomial2.getMonomials().get(j).getGrade();
            double coefficient1 = polynomial1.getMonomials().get(i).getCoefficient();
            double coefficient2 = polynomial2.getMonomials().get(j).getCoefficient();
            if(grade1 == grade2)
            {
                result.addMonomial( coefficient1 - coefficient2, grade1);
                i++;
                j++;
            }
            else if(grade1 > grade2)
            {
                result.addMonomial(coefficient1, grade1);
                i++;
            }
            else
            {
                result.addMonomial(-coefficient2, grade2);
                j++;
            }
        }
        while(i != polynomial1.getMonomials().size())
        {
            result.addMonomial(polynomial1.getMonomials().get(i).getCoefficient(), polynomial1.getMonomials().get(i).getGrade());
            i++;
        }
        while(j != polynomial2.getMonomials().size())
        {
            result.addMonomial(-polynomial2.getMonomials().get(j).getCoefficient(), polynomial2.getMonomials().get(j).getGrade());
            j++;
        }
        return result;
    }

    public static Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        for (Monomial monomial1: polynomial1.getMonomials()) {
            for (Monomial monomial2: polynomial2.getMonomials()) {
                int grade = monomial1.getGrade()+monomial2.getGrade();
                double coefficient = monomial1.getCoefficient()*monomial2.getCoefficient();
                Monomial monResult = result.getMonomialByGrade(grade);
                if(monResult != null)
                {
                    monResult.setCoefficient(monResult.getCoefficient()+coefficient);
                }
                else
                {
                    result.addMonomial(coefficient, grade);
                }
            }
        }
        result.sortMonomials();
        return result;
    }

    public static Polynomial derive(Polynomial polynomial)
    {
        Polynomial result =  new Polynomial();
        for (Monomial monomial: polynomial.getMonomials()) {
            result.addMonomial(monomial.getCoefficient()*monomial.getGrade(), monomial.getGrade()-1);
        }
        return result;
    }

    public static Polynomial integrate(Polynomial polynomial)
    {
        Polynomial result = new Polynomial();
        for (Monomial monomial: polynomial.getMonomials()) {
            result.addMonomial(monomial.getCoefficient()/(monomial.getGrade()+1), monomial.getGrade()+1);
        }
        return result;
    }

    public static Polynomial multiplyPolynomialWithMonomial(Polynomial polynomial, Monomial monomial) {
        Polynomial result = new Polynomial();
        for (Monomial mon : polynomial.getMonomials()) {
            result.addMonomial(mon.getCoefficient() * monomial.getCoefficient(), mon.getGrade() + monomial.getGrade());
        }
        return result;
    }

    public static Polynomial[] divide(Polynomial polynomial1, Polynomial polynomial2)
    {
        Polynomial result = new Polynomial();
        while(polynomial1.getMonomials().get(0).getGrade() >= polynomial2.getMonomials().get(0).getGrade())
        {
            int grade = polynomial1.getMonomials().get(0).getGrade()-polynomial2.getMonomials().get(0).getGrade();
            double coefficient = polynomial1.getMonomials().get(0).getCoefficient()/polynomial2.getMonomials().get(0).getCoefficient();
            Monomial monoResult = new Monomial(grade, coefficient);
            result.addMonomial(monoResult.getCoefficient(), monoResult.getGrade());
            Polynomial intermediatePolynomial = multiplyPolynomialWithMonomial(polynomial2, monoResult);
            polynomial1 = substract(polynomial1, intermediatePolynomial);
            if(polynomial1.getMonomials().size() == 0)
            {
                polynomial1.addMonomial(0, 0);
                break;
            }
        }
        return new Polynomial[]{result, polynomial1};
    }


}
