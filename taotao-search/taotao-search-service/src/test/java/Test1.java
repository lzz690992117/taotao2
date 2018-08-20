import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;



public class Test1 {
    @Test
	public void test() throws SolrServerException, IOException{
   //创建一个SolrServer，使用HttpSolrServer创建对象。    	
	SolrServer solrServer=new HttpSolrServer("http://119.29.170.162:8080/solr");	
	//创建一个文档对象SolrInputDocument对象。
	SolrInputDocument document=new SolrInputDocument();
	//向文档中添加域。必须有id域，域的名称必须在schema.xml中定义。
	document.addField("id", "test001");
	document.addField("item_title", "测试商品");
	document.addField("item_price", "199");
   //把文档添加到索引库中。
	solrServer.add(document);
	solrServer.commit();
	}
	
}
