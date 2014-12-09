var Judo = require('judo');

var options = {
  muteWarnings: false,
  phantomProcs: 1
};

var judo = new Judo();
var urlConfig = {
  baseUrl: 'http://kyoken74.github.io/gwt-angular/',
  siteMapPath: 'sitemap.xml',
  urls: [{
    url: '/index.html',
      siteMap: {
        changefreq: 'daily',
        priority:   '0.8',
        lastmod:    lastmod(new Date())
      }
  }]
};

judo.updateSiteMap(urlConfig, function(err) {
  if (!err) {
    console.log('that was easy!');
  }
});

function lastmod(date) {
  var yyyy = date.getFullYear().toString();
  var mm = (date.getMonth() + 1).toString();
  var dd = date.getDate().toString();
  return yyyy + "-" + (mm[1]?mm:"0"+mm[0]) + "-" + (dd[1]?dd:"0"+dd[0]);
}
