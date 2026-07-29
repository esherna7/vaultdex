import { useQuery } from '@tanstack/react-query';
import axios from 'axios';

async function fetchCards() {
  const { data } = await axios.get('/api/cards');
  return data;
}

export const useCards = () => {
  return useQuery({
    queryKey: ['cards'],
    queryFn: async () => fetchCards(),
    enabled: true,
    staleTime: 1000 * 60 * 5, // 5 minutes
    retry: 3, // Retry failed requests up to 3 times
  });
}

export default useCards;