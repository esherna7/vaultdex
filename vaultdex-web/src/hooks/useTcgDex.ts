import { useQuery } from "@tanstack/react-query";
import { TCGDEX_BASE_URL, API_ROUTES } from "../api/api-config";
import axios from "axios";

async function fetchSets() {
    const { data } = await axios.get(`${TCGDEX_BASE_URL}${API_ROUTES.TCGDEX_GET_SETS}`);
    return data;
}

export const useTcgDexSets = () => {
    return useQuery({
        queryKey: ['tcgdex-sets'],
        queryFn: async () => fetchSets(),
        enabled: true,
        staleTime: 1000 * 60 * 5, // 5 minutes
        retry: 3, // Retry failed requests up to 3 times
    });
}

async function fetchSetById(id: string) {
    const { data } = await axios.get(`${TCGDEX_BASE_URL}${API_ROUTES.TCGDEX_GET_SET_BY_ID.replace(':id', id)}`);
    return data;
}

export const useTcgDexSetById = (id: string) => {
    return useQuery({
        queryKey: ['tcgdex-set', id],
        queryFn: async () => fetchSetById(id),
        enabled: !!id, // Only run the query if id is provided
        staleTime: 1000 * 60 * 5, // 5 minutes
        retry: 3, // Retry failed requests up to 3 times
    });
}