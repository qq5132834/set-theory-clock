package com.paic.arch.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;

import com.paic.arch.interviews.support.BehaviouralTestEmbedder;

import groovy.ui.SystemOutputInterceptor;

import static com.paic.arch.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  
 * You will notice the TimeConverter has no implementation ... (hint)
 */
public class SetTheoryClockDevice {

    private TimeConverter setTheoryClock = new MyTimeConverter();
    private String theTime;

    @Test
    public void setTheoryClockAcceptanceTests() throws Exception {
    	BehaviouralTestEmbedder.aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("set-theory-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
    	System.out.println("==whenTheTimeIs");
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedClockOutput) {
    	
    	
    	String str = setTheoryClock.convertTime(theTime);
    	
//    	System.out.println("-------------------------");
//    	for (int i=0;i<theExpectedClockOutput.length();i++) {
////			System.out.print("["+i+"]"+theExpectedClockOutput.charAt(i));
//    		
//    		int ii = theExpectedClockOutput.charAt(i);
//    		int jj = str.charAt(i);
//    		System.out.print(ii+"/"+jj);
//    		System.out.print(theExpectedClockOutput.charAt(i));
//    		
//		}
//    	System.out.println("\n-------------------------");
    	
        assertThat(str).isEqualTo(theExpectedClockOutput);
    }
}
