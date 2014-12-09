var options = {
  muteWarnings: false,
  phantomProcs: 1
};


var judo = new Judo();
var urlConfig = {
  baseUrl: 'http://kyoken74.github.io/gwt-angular/',
  siteMapPath: '/sitemap.xml',
  urls: [{
    url: '/index.html',
      siteMap: {
        changefreq: 'daily',
        priority:   '0.8',
        lastmod:    '2014-12-06'
      }
  }]
};

judo.updateSiteMap(urlConfig, function(err) {
  if (!err) {
    console.log('that was easy!');
  }
});
