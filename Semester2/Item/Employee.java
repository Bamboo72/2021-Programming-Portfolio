// My own code: Jacob Schwartz - 1/26/2021

public class Employee implements Measurable{

  private double anualWage;
  private double wageWithBenefits;

  public Employee(double anual, double withBenefits){
    anualWage = anual;
    wageWithBenefits = withBenefits;
  }

  /**
     Computes the measure of an object.
     @return the measure
  */
  public double getMeasure(){
    double measure;
    measure = wageWithBenefits - anualWage;
    return measure;
  }

}
