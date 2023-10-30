$(document).ready(function () {
    const $currentPlayer = $("#currentPlayer");
    const $buttons = $(".game button");
    const $restartButton = $("#restart");

    let selected;
    let player = "X";

    let positions = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
        [1, 4, 7],
        [2, 5, 8],
        [3, 6, 9],
        [1, 5, 9],
        [3, 5, 7],
    ];

    function init() {
        selected = [];

        $currentPlayer.text(`VEZ DE: ${player}`);
        $buttons.removeClass("winner").text("").on("click", newMove);
    }

    init();

    function newMove(e) {
        const index = $(e.target).data("i");
        $(e.target).text(player);
        $(e.target).off("click", newMove);
        selected[index] = player;

        setTimeout(check, 100);

        player = player === "X" ? "O" : "X";
        $currentPlayer.text(`VEZ DE: ${player}`);
    }
    function check() {
        const winningCombinations = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8],
            [0, 3, 6], [1, 4, 7], [2, 5, 8],
            [0, 4, 8], [2, 4, 6]
        ];

        for (const combo of winningCombinations) {
            const [a, b, c] = combo;
            if (selected[a] && selected[a] === selected[b] && selected[b] === selected[c]) {
                $currentPlayer.text(`O JOGADOR '${selected[a]}' GANHOU!`);
                $buttons.eq(a).addClass("winner");
                $buttons.eq(b).addClass("winner");
                $buttons.eq(c).addClass("winner");
                $buttons.off("click");
                return;
            }
        }

        if (selected.filter((item) => item).length === 9) {
            $currentPlayer.text("DEU EMPATE!");
            $buttons.off("click");
        }
    }
    $restartButton.on("click", function () {
        $buttons.removeClass("winner");
        init();
    });
});
