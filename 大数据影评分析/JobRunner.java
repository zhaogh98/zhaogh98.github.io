import java.io.IOException;
import java.net.URISyntaxException;

public class JobRunner {

	public static void main(String[] args) {
		int result1 = -1;
		int result2 = -1;
		int result3 = -1;
		int result4 = -1;
		int result5 = -1;
		try {
			String[] step1arges={"input/user.txt","output/step1"};
			result1 = new Step1().run(step1arges);
		}
		catch (Exception e) {
			result1 = -1;
		}
		if(result1 == 1)
		{
			System.out.println("Step1 run success");
			try {
				String[] step2arges={"output/step1/part-r-00000","output/step2"};
				result2 = new Step2().run(step2arges);
			} catch (ClassNotFoundException | IOException | InterruptedException | URISyntaxException e) {
				result2 = -1;
			}
		}
		else
		{
			System.out.println("Step1 run failed");
		}
		
		if(result2 == 1)
		{
			System.out.println("Step2 run success");
			try {
				String[] step3arges={"output/step1/part-r-00000","output/step3"};
				result3 = new Step3().run(step3arges);
			} catch (Exception e) {
				result3 = -1;
			}
		}
		else
		{
			System.out.println("Step2 run failed");
		}
		
		
		if(result3 == 1)
		{
			System.out.println("Step3 run success");
			try {
				String[] step4arges={"output/step2/part-r-00000","output/step4"};
				result4 = new Step4().run(step4arges);
			} catch (Exception e) {
				result4 = -1;
			}
		}
		else
		{
			System.out.println("Step3 run failed");
		}
		
		if(result4 == 1)
		{
			System.out.println("Step4 run success");
			try {
				String[] step5arges={"output/step4/part-r-00000","output/step5"};
				result5 = new Step5().run(step5arges);
			} catch (Exception e) {
				result5 = -1;
			}
		}
		else
		{
			System.out.println("Step4 run failed");
		}
		
		if(result5 == 1)
		{
			System.out.println("Step5 run success");
			System.out.println("job finished ");
		}
		else
		{
			System.out.println("Step5 run failed");
		}
		
	}

}