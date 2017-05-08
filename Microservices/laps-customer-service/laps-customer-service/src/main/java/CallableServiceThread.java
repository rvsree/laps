import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.laps.customer.thread.DocumentManagerCallable;

public class CallableServiceThread {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(5);
		@SuppressWarnings("unchecked")
		Future<String>[] results = new Future[3];
		
		String createFile = "IPBJIB_ME_N10";
		

		for (int index = 0; index < 3; index ++) {
			DocumentManagerCallable documentManager = new DocumentManagerCallable(createFile + index);
			results[index] = executor.submit(documentManager);
		}
		
		for (Future<String> result:results ) {
			try {
				String status = result.get();
				System.out.println("notification Status" + status);
			} catch (ExecutionException ex) {
				ex.printStackTrace();
				Throwable adderEx = ex.getCause();	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {
			executor.shutdown();

			while (!executor.isTerminated()) { }
			System.out.println("Finished all threads");
			executor.awaitTermination(60, TimeUnit.SECONDS);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
