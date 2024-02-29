
	const DISCLAIMER_APPEAR_TIME = 4 * 1000;
    function deleteFilm(title, event) {
    	if (!confirm(`Are you sure you want to delete this film '${title}'?`)) {
    		event.preventDefault();
        } 
    }
    
    setTimeout(function() {
        var disclaimer = document.getElementById('disclaimer');
        disclaimer.classList.add('hidden');
    }, DISCLAIMER_APPEAR_TIME);
