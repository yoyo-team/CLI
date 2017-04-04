let child_process = require('child_process');

module.exports = function(filepath,cid)
{
    let command = 'java -classpath "/web/server/java/yoyo:/web/server/java/yoyo/poi/poi-3.15.jar:/web/server/java/yoyo/poi/poi-ooxml-3.15.jar:/web/server/java/yoyo/poi/poi-excelant-3.15.jar:/web/server/java/yoyo/poi/poi-scratchpad-3.15.jar:/web/server/java/yoyo/poi/poi-ooxml-schemas-3.15.jar:/web/server/java/yoyo/poi/lib/junit-4.12.jar:/web/server/java/yoyo/poi/lib/log4j-1.2.17.jar:/web/server/java/yoyo/poi/lib/commons-codec-1.10.jar:/web/server/java/yoyo/poi/lib/commons-logging-1.2.jar:/web/server/java/yoyo/poi/lib/commons-collections4-4.1.jar:/web/server/java/yoyo/poi/ooxml-lib/curvesapi-1.04.jar:/web/server/java/yoyo/poi/ooxml-lib/xmlbeans-2.6.0.jar" Main';
    command += '  ' + filepath;
    command += '  ' + cid;
    let options =
        {

        };
    return new Promise(function(resolve,reject)
    {
        child_process.exec(command,options,function(err,stdout,stderr)
        {
            if(err)
            {
                reject(err);
                console.log(err);
                console.log(stderr);
            }
            else
            {
                resolve(stdout);
            }
        });
    })
};
//
// module.exports('/web/server/nodejs/deploy/server/apps/yoyo/tmp/1.ppt','test')
//     .then(function(stdout)
//     {
//         console.log(stdout);
//     },function(err)
//     {
//         console.log(err);
//     });