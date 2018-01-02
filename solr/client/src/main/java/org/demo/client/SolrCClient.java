package org.demo.client;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

@RestController("RestController")
public class SolrCClient {
    private static final Logger log = LoggerFactory.getLogger(SolrCClient.class);

    @Value("${krb5.jaas}")
    private String krb5Jaas;

    @Value("${krb5.conf}")
    private String krb5Conf;

    @Value("${krb5.keytab}")
    private String krb5Keytab;

    @Value("${krb5.principal}")
    private String krb5Principal;

    @Value("${solr.zk}")
    private String solrZk;

    @Value("${solr.url}")
    private String solrUrl;

    @Value("${solr.collection}")
    private String solrCollection;

    @RequestMapping("/item")
    public Item item(@RequestParam(value = "name", defaultValue = "World") String name) {
        return this.query(name);
    }

    public Item query(String name) {
        Item item = null;

        // System.setProperty("java.security.auth.login.config", "D:\\Git\\mygit\\java-startup\\solr\\client\\src\\main\\resources\\fhc.dev\\jaas.conf");
        // System.setProperty("java.security.krb5.conf", "D:\\Git\\mygit\\java-startup\\solr\\client\\src\\main\\resources\\fhc.dev\\krb5.conf");
        // System.setProperty("sun.security.krb5.debug", "true");

        System.setProperty("java.security.auth.login.config", krb5Jaas);
        System.setProperty("java.security.krb5.conf", krb5Conf);
        // System.setProperty("sun.security.krb5.debug", "true");

        try {
            CloudSolrServer solr = new CloudSolrServer(solrUrl);
            SolrQuery query = new SolrQuery(name);

            solr.setDefaultCollection(solrCollection);
            solr.setZkClientTimeout(30000);
            solr.setZkConnectTimeout(30000);
            solr.connect();

            QueryResponse response = solr.query(query);
            SolrDocumentList docs = response.getResults();

            System.out.println("文档个数：" + docs.getNumFound());
            System.out.println("查询时间：" + response.getQTime());

            item = new Item();
            for (SolrDocument doc : docs) {
                System.out.println("id: " + doc.getFieldValue("id"));
                System.out.println("name: " + doc.getFieldValue("name"));

                item.setId((String) doc.getFieldValue("id"));
                item.setName((String) doc.getFieldValue("name"));
                item.setStore_no((String) doc.getFieldValue("store_no"));
                item.setInsert_time((String) doc.getFieldValue("insert_time"));
                item.setUpdate_time((String) doc.getFieldValue("update_time"));
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return item;
    }

    /*
    public static void main(String[] args) {
        SolrCClient client = new SolrCClient();
        client.query(new String(""));
    }
    */
}
