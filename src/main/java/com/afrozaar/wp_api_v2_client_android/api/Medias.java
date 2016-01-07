package com.afrozaar.wp_api_v2_client_android.api;

import com.afrozaar.wp_api_v2_client_android.exception.WpApiParsedException;
import com.afrozaar.wp_api_v2_client_android.model.wp_v2.Media;
import com.afrozaar.wp_api_v2_client_android.model.wp_v2.Post;

import org.springframework.core.io.Resource;

import java.util.List;

public interface Medias {

    Media createMedia(Media media, Resource resource) throws WpApiParsedException;

    List<Media> getMedia();

    Media getMedia(Long id);

    Media updateMedia(Media media);

    boolean deleteMedia(Media media);

    boolean deleteMedia(Media media, boolean force);

    Post setPostFeaturedImage(Long postId, Media media);
}
