function DoPost(id){
	document.forms["formUpVote"+id].submit();
}

function denunciarDica(id){
	document.forms["formDenunciar"+id].submit();
}

function denunciarMetaDica(id){
	document.forms["formDenunciarMeta"+id].submit();
}

var index = angular.module('index', []);

index.controller('filterDicaController', function($scope) {
    $scope.filterTimeLine = function(filterTrype){
        window.location = '/?s='+filterTrype;
    }
});


var tema = angular.module('tema', [], function($provide) {
    $provide.factory('msgBus', ['$rootScope', function($rootScope) {
        var msgBus = {};
        msgBus.emitMsg = function(msg) {
            $rootScope.$emit(msg);
        };
        msgBus.onMsg = function(msg, scope, func) {
            var unbind = $rootScope.$on(msg, func);
            scope.$on('$destroy', unbind);
        };
        return msgBus;
    }]);
});



tema.controller('submitDicaController', function($scope, msgBus) {
    this.qty = 1;
    this.current = {};
    var controller = this;
    msgBus.onMsg('somemsg', $scope, function() {
        controller.current = msgBus.selected;
    });
});

tema.controller('submitTypeSelector', function($scope, msgBus) {
    this.qty = 1;

    $scope.assunto =
    {
        titulo: "O que se deve saber para não ter dificuldades neste tema?",
        placeholder: "Assunto",
        typeId: 0
    };

    $scope.disciplina =
    {
        titulo: "Que disciplinas anteriores ajudarão a estudar este tema?",
        placeholder: "Disciplinas",
        typeId: 1
    };

    $scope.material =
    {
        titulo: "Link para material útil relacionado a este tema:",
        placeholder: "URL",
        typeId: 2
    };

    $scope.conselho =
    {
        titulo: "Conselho para quem quiser aprender este tema:",
        placeholder: "",
        typeId: 3
    };
    $scope.sendmsg = function(msg) {
        msgBus.selected = msg;
        msgBus.emitMsg('somemsg');
    }
});
