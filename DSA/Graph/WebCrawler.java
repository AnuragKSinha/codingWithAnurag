package DSA.Graph;
/**
 * https://leetcode.com/problems/web-crawler/
 * Time Complexity:O(n)
 * Space Complexity:O(n)
 */
/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        if(startUrl==null||startUrl.length()==0)
            return new ArrayList<String>();
        Set<String> visited=new HashSet<String>();
        String hostname=getHostname(startUrl);
        dfs(hostname,startUrl,visited,htmlParser);
        return new ArrayList<String>(visited);
    }
    private void dfs(String hostName,String parentUrl,Set<String> visited,HtmlParser htmlParser)     {
        visited.add(parentUrl);
        for(String url:htmlParser.getUrls(parentUrl)){
            if(url.contains(hostName) && !visited.contains(url)){
                dfs(hostName,url,visited,htmlParser);
            }
        }
            
    }
    private String getHostname(String startUrl){
        String[] host=startUrl.split("/");
        return host[2];
    }
}