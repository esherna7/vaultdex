import axios from 'axios';
import { useQuery } from '@tanstack/react-query';
import { API_ROUTES } from '../api/api-config';

async function getGames() {
    try {
        const { data } = await axios.get(API_ROUTES.GAMES);
        return data
    } catch (error) {
        console.error('Error fetching games:', error)
        throw error
    }
}

export const useGames = () => {
    return useQuery({
        queryKey: ['games'],
        queryFn: getGames,
        staleTime: 1000 * 60 * 5, // 5 minutes
        retry: 3,
    })
}