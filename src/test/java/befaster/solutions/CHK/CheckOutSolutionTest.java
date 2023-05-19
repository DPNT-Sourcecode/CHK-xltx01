package befaster.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckOutSolutionTest {

    private CheckoutSolution checkoutSolution;

    @BeforeEach
    public void setup (){
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void compute_checkout(){
        assertThat(checkoutSolution.checkout("ABCDEFF"), equalTo(175));
       assertThat(checkoutSolution.checkout("AAAABBBCEE"), equalTo(325));
       assertThat(checkoutSolution.checkout("EE"), equalTo(80));
       assertThat(checkoutSolution.checkout("EEBFFF"), equalTo(100));
       assertThat(checkoutSolution.checkout("EEEB"), equalTo(120));
    }


}


