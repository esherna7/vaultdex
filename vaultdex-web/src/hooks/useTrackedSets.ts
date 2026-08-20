import { API_ROUTES } from "../api/api-config";
import axios from "axios";
import { useMutation, useQuery } from "@tanstack/react-query";
import { useQueryClient } from "@tanstack/react-query";

export interface TrackedSet {
    id: number;
    gameId: number;
    setId: number;
    setCode: string;
    userId: number;
    trackedAt: string;
}

interface TrackSetPayload {
    setCode: string;
}

async function trackSet({ setCode }: TrackSetPayload) {
    try {
        const { data } = await axios.post(API_ROUTES.TRACK_SET, {
            setCode,
        }, {
            withCredentials: true,
        });
        return data;
    } catch (error) {
        console.error("Failed to track set:", error);
        throw error;
    }
}

export const useTrackSet = () => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: trackSet,
        onSuccess: () => {
            queryClient.invalidateQueries({ queryKey: ['trackedSets'] });
        },
    });
};

async function fetchTrackedSets() {
    try {
        const { data } = await axios.get(API_ROUTES.TRACK_SET, {
            withCredentials: true,
        });
        return data;
    } catch (error) {
        console.error("Failed to fetch tracked sets:", error);
        throw error;
    }
}

export const useTrackedSets = (userId?: number) => {
    return useQuery({
        queryKey: ['trackedSets', userId],
        queryFn: fetchTrackedSets,
        enabled: !!userId,
        staleTime: 1000 * 60 * 5, // 5 minutes
        retry: 3,
    })
}