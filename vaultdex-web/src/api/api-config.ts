export const TCGDEX_BASE_URL = 'https://api.tcgdex.net/v2/en';

export const API_ROUTES = {
    //Games API
    GAMES: '/api/games',

    //TCGdex API
    TCGDEX_GET_SETS: '/sets',
    TCGDEX_GET_SET_BY_ID: '/sets/:id',

    //User API
    USER_REGISTER: '/api/users/register',
    USER_LOGIN: '/api/users/login',

    //Tracked Sets API
    TRACK_SET: '/api/trackedSets',
    UNTRACK_SET: '/api/trackedSets/:id',
}