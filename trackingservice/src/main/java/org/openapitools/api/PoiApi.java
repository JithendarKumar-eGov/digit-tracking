/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0-beta).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ACK;
import org.openapitools.model.POI;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-03T18:26:55.344646900+05:30[Asia/Calcutta]")
@Validated
@Tag(name = "POI", description = "Points of interest (POI) are a combination of location and additional details about that specific location. A POI can be a single LatLong or a polygon (combination of multiple LatLongs)")
public interface PoiApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /poi/_create : Create a new POI by providing location coordinates and additional details
     * Create a new POI by Id
     *
     * @param POI Create a new POI in the system (required)
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "createPOI",
        summary = "Create a new POI by providing location coordinates and additional details",
        description = "Create a new POI by Id",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ACK.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/poi/_create",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ACK> createPOI(
        @Parameter(name = "POI", description = "Create a new POI in the system", required = true) @Valid @RequestBody POI POI
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"116bd8d3-e5a9-4e1c-86dc-b2a9c17e3fb1\", \"responseMessage\" : \"Update is succesful\", \"responseCode\" : \"CODE-123\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /poi/_search : Finds POIs based on a specific parameters
     * Search POIs based on multiple filters
     *
     * @param userId userId to be considered for filter (optional)
     * @param locationName Location name that needs to be considered for filter (optional)
     * @param isAlertLocation set true if only alert locations are needed. Omit this parameter to fetch all locations (optional)
     * @param pageSize  (optional)
     * @param pageNumber  (optional)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "findPOI",
        summary = "Finds POIs based on a specific parameters",
        description = "Search POIs based on multiple filters",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = POI.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poi/_search",
        produces = { "application/json" }
    )
    default ResponseEntity<List<POI>> findPOI(
        @Parameter(name = "userId", description = "userId to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "userId", required = false) String userId,
        @Parameter(name = "locationName", description = "Location name that needs to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "locationName", required = false) String locationName,
        @Parameter(name = "isAlertLocation", description = "set true if only alert locations are needed. Omit this parameter to fetch all locations", in = ParameterIn.QUERY) @Valid @RequestParam(value = "isAlertLocation", required = false) String isAlertLocation,
        @Parameter(name = "pageSize", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize,
        @Parameter(name = "pageNumber", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"distanceMeters\" : 200000, \"locationName\" : \"Any name assigned to the location\", \"alert\" : \"alert\", \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"userId\" : \"rajan123\", \"status\" : \"active\" }, { \"distanceMeters\" : 200000, \"locationName\" : \"Any name assigned to the location\", \"alert\" : \"alert\", \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"userId\" : \"rajan123\", \"status\" : \"active\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /poi/{poiId} : Find POI by its id
     * Returns a single POI
     *
     * @param poiId ID of POI to return (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "getPoiById",
        summary = "Find POI by its id",
        description = "Returns a single POI",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = POI.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poi/{poiId}",
        produces = { "application/json" }
    )
    default ResponseEntity<POI> getPoiById(
        @Parameter(name = "poiId", description = "ID of POI to return", required = true, in = ParameterIn.PATH) @PathVariable("poiId") String poiId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"distanceMeters\" : 200000, \"locationName\" : \"Any name assigned to the location\", \"alert\" : \"alert\", \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"userId\" : \"rajan123\", \"status\" : \"active\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /poi/_searchNearby/{latitude}/{longitude}/{distanceMeters} : Find POIs near a user location
     * Returns a multiple POIs
     *
     * @param latitude Latitude of the user location (required)
     * @param longitude longitude of the user location (required)
     * @param distanceMeters Distance near the user to be searched (required)
     * @return successful operation (status code 200)
     */
    @Operation(
        operationId = "searchNearby",
        summary = "Find POIs near a user location",
        description = "Returns a multiple POIs",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = POI.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poi/_searchNearby/{latitude}/{longitude}/{distanceMeters}",
        produces = { "application/json" }
    )
    default ResponseEntity<List<POI>> searchNearby(
        @Parameter(name = "latitude", description = "Latitude of the user location", required = true, in = ParameterIn.PATH) @PathVariable("latitude") Float latitude,
        @Parameter(name = "longitude", description = "longitude of the user location", required = true, in = ParameterIn.PATH) @PathVariable("longitude") Float longitude,
        @Parameter(name = "distanceMeters", description = "Distance near the user to be searched", required = true, in = ParameterIn.PATH) @PathVariable("distanceMeters") Integer distanceMeters
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"distanceMeters\" : 200000, \"locationName\" : \"Any name assigned to the location\", \"alert\" : \"alert\", \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"userId\" : \"rajan123\", \"status\" : \"active\" }, { \"distanceMeters\" : 200000, \"locationName\" : \"Any name assigned to the location\", \"alert\" : \"alert\", \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"userId\" : \"rajan123\", \"status\" : \"active\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /poi/_update : Update an existing POI using its id
     * Update an existing POI by Id
     *
     * @param POI Update an existent POI in the system (required)
     * @return Successful operation (status code 200)
     */
    @Operation(
        operationId = "updatePOI",
        summary = "Update an existing POI using its id",
        description = "Update an existing POI by Id",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/poi/_update",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updatePOI(
        @Parameter(name = "POI", description = "Update an existent POI in the system", required = true) @Valid @RequestBody POI POI
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
