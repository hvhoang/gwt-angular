(function (){ //++ start of snapshots.js

var Judo = require('judo');
var judo = new Judo();

var options = {
  muteWarnings: false,
  phantomProcs: 1
};

var urlConfig = {
  baseUrl: 'http://gwt-angular.asayama.com/index.html',
  snapshotsDir: 'site/snapshots',
  urls: [{
      url: '#!/jumbotron',
      snapshot: {
        filenames: [ 'jumbotron.html' ]
      }
    },{
      url: '#!/downloads',
      snapshot: {
        filenames: [ 'downloads.html' ]
      }
    },{
      url: '#!/documentation',
      snapshot: {
        filenames: [ 'documentation.html' ]
      }
    },{
      url: '#!/tutorial',
      snapshot: {
        filenames: [ 'tutorial.html' ]
      }
    },{
      url: '#!/examples',
      snapshot: {
        filenames: [ 'examples.html' ]
      }
    }]
};

judo.createSnapshots(urlConfig, function(err){
  if (!err) console.log('that was easy!');
});

})(); //-- end of snapshots.js
