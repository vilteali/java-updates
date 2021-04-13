package curso.process;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

public class ProcessInformation {

	public static void main(String[] args) {
		ProcessHandle self = ProcessHandle.current();
		long PID = self.pid();
		System.out.println(PID);
		ProcessHandle.Info procInfo = self.info();
		  
		Optional<String[]> args2 = procInfo.arguments();
		System.out.println("-----------");
		//args2.get();
		System.out.println(args2);
		Optional<String> cmd =  procInfo.commandLine();
		System.out.println("-----------");
		System.out.println(cmd);
		Optional<Instant> startTime = procInfo.startInstant();
		System.out.println("-----------");
		System.out.println(startTime);
		Optional<Duration> cpuUsage = procInfo.totalCpuDuration();
		System.out.println("-----------");
		System.out.println(cpuUsage);
		
		/*
		 * ProcessHandle.current().children().forEach(procHandle -> {
		 * assertTrue("Could not kill process " + procHandle.pid(),
		 * procHandle.destroy()); });
		 */
	}

}
