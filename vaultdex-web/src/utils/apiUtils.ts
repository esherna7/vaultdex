export const COMPILE_PATH = async (apiRoute: string, params: Record<string, any>) => {
    const queryString = new URLSearchParams(params).toString();
    return `${apiRoute}?${queryString}`;
}

export const GET_FROM_PATH = async (apiRoute: string, params: Record<string, any>) => {
    try {
        const url = await COMPILE_PATH(apiRoute, params);
        const response = await fetch(url);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        throw error;
    }
}