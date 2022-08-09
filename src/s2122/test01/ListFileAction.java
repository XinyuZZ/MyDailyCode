package s2122.test01;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ListFileAction extends RecursiveAction {

    private File path;

    public ListFileAction(File path){
        this.path=path;
    }

    @Override
    protected void compute() {
        List<ListFileAction> subActions= new ArrayList<>();
        File[] files = path.listFiles();
        if(files !=null){
            for(File file : files){
                if(file.isDirectory()){
                    // 把遍历到是目录的文件添加到任务集合中
                    subActions.add(new ListFileAction(file));
                } else {
                    // 如果是文件，检查是否是TXT，是就打印
                    if(file.getAbsolutePath().endsWith("txt")){
                        System.out.println("文件："+file.getAbsolutePath());
                    }
                }
            }
            //遍历完成后判断集合是否为空，不为空的话一起合并
            if(!subActions.isEmpty()){
                Collection<ListFileAction> endFils = invokeAll(subActions);

                for(ListFileAction subAction: endFils){
                    subAction.join();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 声明一个forkjoin池调度任务
        ForkJoinPool pool = new ForkJoinPool();
        // 实例化类并给与其从哪里开始执行的文件路径
        ListFileAction action = new ListFileAction(new File("/Users/jensen/Downloads"));
        // 异步提交
        pool.execute(action);
//        System.out.println("Task is Running.....");
//        Thread.sleep(500);
//        int otherWork=0;
//        for(int i = 0 ; i < 100;i++){
//            otherWork=otherWork+i;
//        }

//        System.out.println("Main Thread done sth..... , otherWork="+otherWork);
        //阻塞方法
        action.join();
//        System.out.println("Task end");
    }

}
