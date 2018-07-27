package com.yt;


import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * All rights Reserved, Designed By www.75271.com
 * @Title:  abc.java   
 * @Package com.example.demo   
 * @Description:    1到1000000 计数的多线程累加    
 * @author: 开心洋葱 
 * @mail:   431910788@qq.com 
 * @date:   2018年7月27日 下午3:54:15   
 * @version V1.0  
 * @Copyright: 2018 www.75271.com Inc. All rights reserved. 
 * 注意：本内容仅限于杨涛及其授权用户使用，禁止外泄以及用于其他的商业目
 */
public class CallableTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int n = 10;//线程数
        long start=1L;//开始值
        long end=1000000000L;//结束值
        long sum = 0L;
        ExecutorService threads = Executors.newFixedThreadPool(n);
        CompletionService<Long> cs = new ExecutorCompletionService<Long>(threads);
        for(int i=0;i<n;i++){
            cs.submit(new SumCallable(start, end, n, i));
        }
        threads.shutdown();//关闭service
        for(int i=0;i<n;i++){
            try {
                sum += cs.take().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("和："+sum+",耗时："+(endTime-startTime)+"ms");
    }

}
class SumCallable implements Callable<Long>{
    private long start;
    private long end;
    public SumCallable(long start, long end, int n, int index){
        this.start = index * (end-start)/n;
        this.end = (index+1) * (end-start)/n-1;
        if(index==0){
            this.start = start;
        }
        if(index == n-1){
            this.end = end;
        }
    }

    @Override
    public Long call() throws Exception {
        long sum = 0;
        for(long i=start;i<=end;i++){
            sum +=i;
        }
        System.out.println(Thread.currentThread().getName()+":"+sum);
        return sum;
    }
    
}