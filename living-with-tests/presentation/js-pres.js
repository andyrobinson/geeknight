var reminder_mins = $('#reminder_mins').text();
var show_opening_message_yes_or_no = $('#show_opening_message_yes_or_no').text();

if (reminder_mins) {
    setInterval(function () { alert('hurry up - that was ' + reminder_mins + ' mins already!');}, 60 * 1000 * reminder_mins);
}

var currentSlideIndex;

showCurrentSlide = function() {
	$('.slide').hide();
	currentSlide().show();
	hideAllItemsOnCurrentSlide();
}

nextSlide = function() {
	currentSlideIndex = currentSlideIndex + 1;
	showCurrentSlide();
};

prevSlide = function() {
	currentSlideIndex = Math.max(currentSlideIndex - 1, 0);
	showCurrentSlide();
	revealNextItem();
};

revealNextItem = function() {
	$($('.reveal li:hidden', currentSlide()).get(0)).show();
};

hideAllItemsOnCurrentSlide = function() {
	$('.reveal li', currentSlide()).hide();
};

currentSlide = function() {
	return $($('.slide').get(currentSlideIndex));
};


initSlides = function() {
	$('.slide').hide();
	currentSlideIndex = -1;
	nextSlide();
};

hasUnrevealedItems = function() {
	return $('.reveal li', currentSlide()).size() > $('.reveal li:visible', currentSlide()).size();
};

next = function() {
	if (hasUnrevealedItems()) {
		revealNextItem();
	}
	else {
		nextSlide();
	}
}


$(document).ready(function() {
	initSlides();

	if (show_opening_message_yes_or_no === 'yes') {
		alert('Welcome to a talk on ' + $('title').text());
	}

	$(window).keypress(function(e) {
		if (e.keyCode === 13) {
			nextSlide();
		}
		else if (e.keyCode === 112) { // 'p'
			prevSlide();
		}
		else {
			next();		
		}
	});
});
